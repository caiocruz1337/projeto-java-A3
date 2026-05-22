package cadastroalunos;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class InteligenciaArtificial {

    private static final String CHAVE = System.getenv("GROQ_API_KEY");
    private static final String URL = "https://api.groq.com/openai/v1/chat/completions";

    public String verificarInconsistencias(String nome, String curso, String dataNascimento, String cpf, String telefone, String email) {
        if (CHAVE == null || CHAVE.isBlank()) {
            return "ERRO: Chave GROQ_API_KEY nao configurada.";
        }

        String prompt = """
        Analise os dados de cadastro do aluno abaixo e verifique se existe alguma inconsistencia.
        Considere inconsistencia: CPF que nao tenha exatamente 11 digitos numericos,
        email invalido, data de nascimento invalida, curso vazio, nome vazio,
        telefone muito curto ou dados que parecem incoerentes.
        O CPF pode ser digitado somente com numeros, sem pontos e sem hifen.

        Responda APENAS de uma destas formas:
        OK
        ou
        INCONSISTENCIA: explique o problema em uma frase curta.

        Nome: %s
        Curso: %s
        Data de Nascimento: %s
        CPF: %s
        Telefone: %s
        Email: %s
        """.formatted(nome, curso, dataNascimento, cpf, telefone, email);

        String corpo = """
                {
                    "model": "llama-3.3-70b-versatile",
                    "messages": [{
                        "role": "user",
                        "content": "%s"
                    }],
                    "max_tokens": 200
                }
                """.formatted(escaparJson(prompt));

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

            if (response.statusCode() != 200 || resposta.contains("\"error\"")) {
                System.out.println("Erro da API Groq. Status: " + response.statusCode());
                System.out.println("Resposta Groq: " + resposta);
                return "ERRO: Servico de IA indisponivel no momento.";
            }

            int inicio = resposta.indexOf("\"content\":\"");
            if (inicio >= 0) {
                inicio += 11;
            }

            if (inicio < 0) {
                inicio = resposta.indexOf("\"content\": \"");
                if (inicio >= 0) {
                    inicio += 12;
                }
            }

            if (inicio < 0) {
                return "ERRO: Nao foi possivel ler a resposta da IA.";
            }

            int fim = resposta.indexOf("\"", inicio);
            if (fim < 0) {
                return "ERRO: Nao foi possivel ler a resposta da IA.";
            }

            String resultado = resposta.substring(inicio, fim).trim();
            return resultado.replace("\\n", " ");

        } catch (Exception e) {
            System.out.println("Erro ao chamar IA: " + e.getMessage());
            return "ERRO: " + e.getMessage();
        }
    }

    private String escaparJson(String texto) {
        return texto
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r");
    }
}
