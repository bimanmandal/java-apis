package com.biman.googlesheets;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public class GoogleSheetMain {
    public static void main(String[] args) throws GeneralSecurityException, IOException {

        Sheets sheets = GoogleSheetsService.getSheets();

        // Create A SpreadSheet
        /*Spreadsheet spreadsheet = new Spreadsheet().setProperties(new SpreadsheetProperties().setTitle("My SpreadSheet"));
        spreadsheet = sheets.spreadsheets().create(spreadsheet).setFields("spreadsheetId").execute();
        System.out.println(spreadsheet.getSpreadsheetId());*/

        String SPREADSHEET_ID = "1mgBVXC-uY3JQMiy3J-jTUjHl_WMEHuP2jj92dyD3Ffo";

        // Write into a sheet
        /*ValueRange body = new ValueRange()
                .setValues(Arrays.asList(
                        Arrays.asList("Expenses January"),
                        Arrays.asList("books", "30"),
                        Arrays.asList("pens", "10"),
                        Arrays.asList("Expenses February"),
                        Arrays.asList("clothes", "20"),
                        Arrays.asList("shoes", "5")));
        UpdateValuesResponse result = sheets.spreadsheets().values()
                .update(SPREADSHEET_ID, "A1", body)
                .setValueInputOption("RAW")
                .execute();*/

        // Read from a sheet
        BatchGetValuesResponse readResult = sheets.spreadsheets().values()
                .batchGet(SPREADSHEET_ID)
                .setRanges(Arrays.asList("A1"))
                .execute();

        readResult.entrySet().forEach(stringObjectEntry -> {
            System.out.println(stringObjectEntry.getKey() + " " + stringObjectEntry.getValue());
        });


    }
}
