package com.example.mygmailapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.AsyncTaskLoader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class Front_Activity extends AppCompatActivity {

    private Context context;
    private ListView nameList;
    private String personId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        nameList = findViewById(R.id.nameList);
        context = Front_Activity.this;
        personId = "me";

        AsyncTask<String,Void,Void> asyncMail = new AsyncTask<String, Void, Void>() {
            @Override
            protected Void doInBackground(String... strings) {
                try {
                    try {
                        // ignore personId, tview your dont  really need them
                        Log.i("TAG", "doInBackground: true");
                        GmailQuickstart.start(context, personId);
                        Log.i("TAG", "doInBackground: false");
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (GeneralSecurityException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        asyncMail.execute("");
        /*final ArrayList<String> Name = new ArrayList<>();
        final NetHttpTransport HTTP_TRANSPORT;
        try {
            HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            String user = "me";
            ListLabelsResponse listResponse = service.users().labels().list(user).execute();
            List<Label> labels = listResponse.getLabels();
            if (labels.isEmpty()) {
                Toast.makeText(Front_Activity.this, "No label found", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Front_Activity.this, "labels found", Toast.LENGTH_SHORT).show();
                for (Label label : labels) {
                    Name.add(label.getId());
                }
            }
            ArrayAdapter nameAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Name);
            nameList.setAdapter(nameAdapter);
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/
    }
}