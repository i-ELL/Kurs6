package com.example.kurs6.service;

import com.example.kurs6.dto.SentenceDTO;
import com.example.kurs6.entity.Sentence;
import com.example.kurs6.repository.SentenceRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
@AllArgsConstructor
public class SentenceService {

    private SentenceRepository sentenceRepository;
    private WordService wordService;

    public Sentence create(SentenceDTO dto){
        Sentence sentence = Sentence.builder()
                .sentence(dto.getSentence())
                .translate(dto.getTranslate())
                .word(wordService.readById(dto.getWordId()))
                .build();
        return sentenceRepository.save(sentence);
    }

    public HttpResponse<String> someMethod(HttpRequest request) throws IOException, InterruptedException {
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            return  response;
        }

        public Sentence createByAPI(Long word_id){
            String text = "0";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://od-api-sandbox.oxforddictionaries.com/api/v2/sentences/en/" + wordService.readById(word_id).getWord()))
                    .header("app_id", "094d279b")
                    .header("app_key", "6bd09773b6ab0792cf88e453401db5f4")
                    .header("Accept", "application/json")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            try {
                HttpResponse<String> response = someMethod(request);
                JSONObject jsonObject = new JSONObject(response.body());
                JSONArray resultsArray = jsonObject.getJSONArray("results");
                JSONObject firstResult = resultsArray.getJSONObject(0);
                JSONArray lexicalEntriesArray = firstResult.getJSONArray("lexicalEntries");
                JSONObject firstLexicalEntry = lexicalEntriesArray.getJSONObject(0);
                JSONArray sentencesArray = firstLexicalEntry.getJSONArray("sentences");
                JSONObject firstSentence = sentencesArray.getJSONObject(0);
                String firstSentenceText = firstSentence.getString("text");
                String[] sentences = firstSentenceText.split("\\.");
                String firstSentence1 = sentences[0].trim() + ".";
                text = firstSentence1;
            }
            catch (IOException e){
                System.out.println("ex!");
            }
            catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }

            Sentence sentence = Sentence.builder()
                    .sentence(text)
                    .translate(text)
                    .word(wordService.readById(word_id))
                    .build();
            return sentence;
    }
    public List<Sentence> readAll(){
        return sentenceRepository.findAll();
    }

    public List<Sentence> readByWordId(Long id){
        return sentenceRepository.findByWordId(id);
    }

    public Sentence update(Sentence sentence){
        return sentenceRepository.save(sentence);
    }

    public void delete(Long id){
        sentenceRepository.deleteById(id);
    }

}
