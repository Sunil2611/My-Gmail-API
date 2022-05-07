package com.example.mygmailapi;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.security.GeneralSecurityException;

    public class AsyncMail extends AsyncTask<String, Void, String> {

        Context context;
        private String personId = "me";
        private TextView tview;

        public AsyncMail(Context c) {
            context = c;
        }

        public AsyncMail() {
        }

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }




/*
        Context context;

        static HttpTransport HTTP_TRANSPORT = AndroidHttp.newCompatibleTransport();
        static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

        public AsyncMail (Context c) {
            context = c;
        }

        @Override
        protected Void doInBackground (String... strings) {

            try {
                AssetManager assetManager = context.getAssets();
                InputStream jsonStream = assetManager.open("mail.json");

                // those 2 tryings also works but gave me the same error
            ServiceAccountCredentials sourceCredentials = ServiceAccountCredentials.fromStream(jsonStream);
            sourceCredentials = (ServiceAccountCredentials) sourceCredentials.createScoped(Arrays.asList("https://mail.google.com/", "https://www.googleapis.com/auth/iam"));

            GoogleCredential credential = GoogleCredential.fromStream(jsonStream).createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform", GmailScopes.MAIL_GOOGLE_COM));
            Gmail gmail = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential).build();*/

/*
                GoogleCredentials credential = GoogleCredentials.fromStream(jsonStream)
                        .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform", "https://www.googleapis.com/auth/dialogflow", GmailScopes.MAIL_GOOGLE_COM));
                credential.refreshIfExpired();
                AccessToken accessToken = credential.getAccessToken ();
                String AuthToken = accessToken.getTokenValue ();


                HttpRequestInitializer requestInitializer = new HttpCredentialsAdapter (credential);


                Gmail gmail = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, requestInitializer).build();

                MimeMessage mimeMessage = createEmail ("avitalh@gmail.com", "sendmail@mail-291708.iam.gserviceaccount.com", "subbb", "bodyyyy");

                Message message = createMessageWithEmail(mimeMessage);

                gmail.users().messages().send ("sendmail@mail-291708.iam.gserviceaccount.com", message).execute();


            } catch (IOException | MessagingException e) {
                e.printStackTrace ();
            }

            return null;
        }

        private Message createMessageWithEmail (MimeMessage emailContent) throws IOException, MessagingException {

            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            emailContent.writeTo(buffer);
            byte[] bytes = buffer.toByteArray();
            String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
            Message message = new Message ();
            message.setRaw(encodedEmail);
            return message;
        }

        public static MimeMessage createEmail(String to, String from, String subject, String bodyText) throws MessagingException {

            Properties props = new Properties ();
            Session session = Session.getDefaultInstance(props, null);

            MimeMessage email = new MimeMessage(session);

            email.setFrom(new InternetAddress (from));
            email.addRecipient(javax.mail.Message.RecipientType.TO,
                    new InternetAddress(to));
            email.setSubject(subject);
            email.setText(bodyText);
            return email;
        }
    }
}
*/