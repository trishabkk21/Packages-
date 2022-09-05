package edu.virginia.cs.nbateams;

import org.json.JSONObject;

public class FakeBallDontLieReader extends BallDontLieReader {
    @Override
    public JSONObject getAllNBATeams() {
        String jsonText = getMockJSONText();
        return new JSONObject(jsonText);
    }

    private String getMockJSONText() {
        return """
                {"data":[
                    {"id":2,"abbreviation":"BOS","city":"Boston","conference":"East","division":"Atlantic","full_name":"Boston Celtics","name":"Celtics"},
                    {"id":14,"abbreviation":"LAL","city":"Los Angeles","conference":"West","division":"Pacific","full_name":"Los Angeles Lakers","name":"Lakers"}
                  ]
                }
                """;
    }
}
