package com.biman.googlesheets;

import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

import static com.google.api.client.googleapis.javanet.GoogleNetHttpTransport.newTrustedTransport;

public class GoogleSheetsService {

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    // put your file under resources directory
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private static Sheets sheetService;

    private static GoogleCredentials getCredential() throws IOException {
        InputStream inputStream = Test.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        return ServiceAccountCredentials.fromStream(inputStream)
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));
    }

    public static Sheets getSheets() throws GeneralSecurityException, IOException {
        if (sheetService == null ){
            final NetHttpTransport HTTP_TRANSPORT = newTrustedTransport();
            final HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter(getCredential());
            sheetService = new Sheets.Builder(
                    HTTP_TRANSPORT,
                    JSON_FACTORY,
                    requestInitializer
            ).setApplicationName(APPLICATION_NAME).build();
        }
        return sheetService;
    }
}
