package com.example.brain.intent;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.w3c.dom.Text;

import java.util.Iterator;
import java.util.Set;

import static android.Manifest.permission.CALL_PHONE;
import static android.content.Intent.ACTION_CALL;

public class MainActivity extends AppCompatActivity {

    private static final int CONTACT_PICKER_RESULT = 1001;
    private static final int RESULT_PICK_CONTACT = 85500;
    static final int PICK_CONTACT_REQUEST = 1;  // The request code
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final int TAKE_PICTURE = 1;
    public static final int CONTACT_VIEW = 2;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void abrirSite(View v) {
        Uri url = Uri.parse("http://www.cardapio01.com");
        Intent it = new Intent(Intent.ACTION_VIEW);
        it.setData(url);
        startActivity(it);
    }

    public void telefonar(View v) {


        chamarNumero("+556492461227");


    }

    public void chamarNumero(String numeroTelefone){


        Intent it = new Intent(Intent.ACTION_CALL);
        it.setData(Uri.parse("tel:" + numeroTelefone));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(it);

    }

    public void dispatchTakePictureIntent(View v) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
//            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
//            startActivityForResult(takePictureIntent, TAKE_PICTURE);
            startActivity(takePictureIntent);
        }
    }

    public void streetViewIF(View v) {
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=-17.810798,-49.209139");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void casa(View v) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Casa");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void contato(View v) {

        Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));
        pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
        startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);

    }

    public void pesquisar(View v){

        TextView pesquisa = (TextView) findViewById(R.id.pesquisa);
        String url = "http://www.google.com/#q=";
        String query = pesquisa.getText().toString().replace(" ", "+").trim();
        String final_url = url + query;
        Uri uri = Uri.parse(final_url);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        // Check which request it is that we're responding to
        if (requestCode == PICK_CONTACT_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                // Get the URI that points to the selected contact
                Uri contactUri = data.getData();
                // We only need the NUMBER column, because there will be only one row in the result
                String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER};

                // Perform the query on the contact to get the NUMBER column
                // We don't need a selection or sort order (there's only one result for the given URI)
                // CAUTION: The query() method should be called from a separate thread to avoid blocking
                // your app's UI thread. (For simplicity of the sample, this code doesn't do that.)
                // Consider using CursorLoader to perform the query.
                Cursor cursor = getContentResolver()
                        .query(contactUri, projection, null, null, null);
                cursor.moveToFirst();

                // Retrieve the phone number from the NUMBER column
                int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                int  nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);

                String numero = cursor.getString(column);

                chamarNumero(numero);


            }
        }
    }

}
