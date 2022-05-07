package com.example.mygmailapi;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Label;
import com.google.api.services.gmail.model.ListLabelsResponse;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private ListView nameList;
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    //private String your_client_id = "1046779217784-rj3tt27u9u3lcl8q5ni60k0gek76odg6.apps.googleusercontent.com";
    //private String your_api_key = "AIzaSyBWGLJejjnvvbhvse-=hj1_6TBBgw_H6wzUGCIYJLyCbGE";
    private EditText personId;
    private EditText msgBody;
    private Button sendBtn;

    public String emailId;
    public String msgB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personId = findViewById(R.id.RecEmail);
        msgBody = findViewById(R.id.message);
        sendBtn = findViewById(R.id.sendButton);
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailId = personId.getText().toString();
                msgB = msgBody.getText().toString();
                if (emailId.isEmpty() || msgB.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Entered Complete Response", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this,Front_Activity.class);
                    startActivity(intent);
                }
            }
        });

/*
        AccountManager accountManager = AccountManager.get(this);
        Bundle options = new Bundle();

        accountManager.getAuthToken(
                myAccount_,                     // Account retrieved using getAccountsByType()
                "Manage your tasks",            // Auth scope
                options,                        // Authenticator-specific options
                this,                           // Your activity
                new OnTokenAcquired(),          // Callback called when a token is successfully acquired
                new Handler(new OnError()));


        URL url = new URL("https://www.googleapis.com/tasks/v1/users/@me/lists?key=" + your_api_key);
        URLConnection conn = (HttpURLConnection) url.openConnection();
        conn.addRequestProperty("client_id", your_client_id);
        conn.addRequestProperty("client_secret", your_client_secret);
        conn.setRequestProperty("Authorization", "OAuth " + token);
*/

        //  nameList = findViewById(R.id.nameList);
        /*f
         */
        /*
    private class OnTokenAcquired implements AccountManagerCallback<Bundle> {
        @Override
        public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
            Bundle bundle = null;
            try {
                bundle = accountManagerFuture.getResult();
            } catch (AuthenticatorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (OperationCanceledException e) {
                e.printStackTrace();
            }
            String token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
        }
    }
*/
    }
}