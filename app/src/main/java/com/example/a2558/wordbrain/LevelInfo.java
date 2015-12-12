package com.example.a2558.wordbrain;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBIndexRangeKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by a2558 on 12/11/2015.
 */

@DynamoDBTable(tableName = "levelInfo")
public class LevelInfo {
    private String docID;
    private List<PackInfo> levels;

    @DynamoDBHashKey(attributeName = "docID")
    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    @DynamoDBAttribute(attributeName = "levels")
    public List<PackInfo> getLevels() {
        return levels;
    }

    public void setLevels(List<PackInfo> levels1) {
        this.levels = levels1;
    }
}



