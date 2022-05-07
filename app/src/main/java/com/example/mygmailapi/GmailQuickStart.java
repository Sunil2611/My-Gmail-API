package com.example.mygmailapi;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.GmailScopes;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;


/* class to demonstrate use of Gmail list labels API */
    class GmailQuickstart {
    private static final String APPLICATION_NAME = "My Gmail API";
    /** Global instance of the JSON factory. */
    private static final String KEY = "API_KEY";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /** Directory to store authorization tokens for this application. */
    private static final String TOKENS_DIRECTORY_PATH = "tokens";
    private static final List<String> SCOPES = Collections.singletonList(GmailScopes.GMAIL_LABELS);
    private static final String CREDENTIALS_FILE_PATH = "credentials.json";

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
        // Load client secrets.
        Log.i("tag", CREDENTIALS_FILE_PATH);
        InputStream in = GmailQuickstart.class.getClassLoader().getResourceAsStream(CREDENTIALS_FILE_PATH);
        //InputStream in = getAssets().open("/credentials.json");
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        Log.i("TAG", "Gmail Quick start cred o");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
        Log.i("TAG", "Gmail Quick start cred o1");
        // Build flow and trigger user authorization request.
        File tokenFolder = new File(Environment.getExternalStorageDirectory() +
                File.separator + TOKENS_DIRECTORY_PATH);
        if (!tokenFolder.exists()) {
            tokenFolder.mkdirs();
        }
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(tokenFolder))
                .setAccessType("offline")
                .build();
        Log.i("TAG", "Gmail Quick start cred o2");
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        Log.i("TAG", "Gmail Quick start cred o3");
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        //returns an authorized Credential object.
        return credential;
        /*
            protected void onAuthorization(AuthorizationCodeRequestUrl authorizationUrl) throws IOException {
                String url = authorizationUrl.build();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(browserIntent);
            }
        };
    }*/
    }

    public static void start(Context c, String personId) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Log.i("TAG", "Gmail Quick start");
        Gmail service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();
        Log.i("TAG", "Gmail Quick start next");
        // Print the labels in the user's account.

        Log.i("Hello",service.toString());
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(c, "Gmail service ok", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        Log.i("TAG", "BLA");
        // Print the labels in the user's account.
        String userid = "me";
        ListLabelsResponse listResponse = service.users().labels().list(userid).execute();
        List<Label> labels = listResponse.getLabels();
        //service.
        if (labels.isEmpty()) {
            Log.i("TAG", "  No Labels present ");
        } else {
            for (Label label : labels) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        Toast toast = Toast.makeText(c, label.toString(), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        }
    }
    }


     /*   public static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
            // Load client secrets.
            InputStream in = GmailQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
            if (in == null) {
                throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
            }
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

            // Build flow and trigger user authorization request.
            File tokenFolder = new File(Environment.getExternalStorageDirectory() +
                    File.separator + TOKENS_DIRECTORY_PATH);
            if (!tokenFolder.exists()) {
                tokenFolder.mkdirs();
            }
 */