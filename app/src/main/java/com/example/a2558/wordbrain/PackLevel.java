package com.example.a2558.wordbrain;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.List;

/**
 * Created by a2558 on 12/11/2015.
 */
@DynamoDBTable(tableName = "packLevels")
public class PackLevel {
    private String puzzleID;
    private String words;
    private List<String> answers;

    @DynamoDBHashKey(attributeName="puzzleID")
    public String getPuzzleID(){
        return puzzleID;
    }
    public void setPuzzleID(String puzzleID1){
        this.puzzleID = puzzleID1;
    }

    @DynamoDBAttribute(attributeName="answers")
    public List<String> getAnswers(){
        return answers;
    }
    public void setAnswers(List<String> answers1){
        this.answers = answers1;
    }

    @DynamoDBAttribute(attributeName="words")
    public String getWords(){
        return words;
    }
    public void setWords(String words1){
        this.words = words1;
    }
}

