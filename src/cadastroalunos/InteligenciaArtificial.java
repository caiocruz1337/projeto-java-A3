package cadastroalunos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class InteligenciaArtificial {

    private static final String CHAVE = "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";
    private static final String URL = "https://api.groq.com/openai/v1/chat/completions";

    public String gerarMatricula(String nome, String curso, String dataNascimento, String cpf) {
    String prompt = """
        Gere um numero de matricula universitaria para o aluno abaixo.
        Responda APENAS com o numero da matricula, sem texto adicional.
        Formato: ANO + CURSO (3 letras maiusculas) + NUMERO SEQUENCIAL (4 digitos)
        Exemplo: 2024ADS0001

        Nome: %s
        Curso: %s
        Data de Nascimento: %s
        CPF: %s
        """.formatted(nome, curso, dataNascimento, cpf);

        String corpo = """
                {
                    "model": "llama-3.3-70b-versatile",
                    "messages": [{
                        "role": "user",
                        "content": "%s"
                    }],
                    "max_tokens": 100
                }
                """.formatted(prompt.replace("\n", "\\n").replace("\"", "\\\""));

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + CHAVE)
                    .POST(HttpRequest.BodyPublishers.ofString(corpo))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String resposta = response.body();


            if (resposta.contains("\"error\"")) {
                System.out.println("Erro da API Groq.");
                return "ERRO: Servico de IA indisponivel no momento.";
            }

            int inicio = resposta.indexOf("\"content\":\"") + 11;
if (inicio == 10) {
    inicio = resposta.indexOf("\"content\": \"") + 12;
}
int fim = resposta.indexOf("\"", inicio);
String resultado = resposta.substring(inicio, fim).trim();
return resultado;

        } catch (Exception e) {
            System.out.println("Erro ao chamar IA: " + e.getMessage());
            return "ERRO: " + e.getMessage();
        }
    }
}
