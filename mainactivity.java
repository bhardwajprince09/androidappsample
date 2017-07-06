package com.example.prince.talkshauk;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {
        private static final String TAG = "ChatActivity";

        private ChatArrayAdapter adp;
        private ListView list;
        private EditText chatText;
        private Button send;
        Intent in;
        private boolean side = false;

        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);

                setContentView(R.layout.activity_main);
                Intent i = getIntent();

                send = (Button) findViewById(R.id.btn);
                list = (ListView) findViewById(R.id.listview);
                adp = new ChatArrayAdapter(getApplicationContext(), R.layout.chat);
                list.setAdapter((ListAdapter) adp);
                chatText = (EditText) findViewById(R.id.chat);
                chatText.setOnKeyListener(new OnkeyListener() {
                        public boolean onKey(View v, int keyCode, KeyEvent event) {
                                {
                                        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                                                return sendChatMessage();
                                        }
                                        return false;
                                }
                        }


                });


                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                                        .setAction("Action", null).show();
                                sendChatMessage();

                        }
                });
        }


private boolean sendChatMessage() {
        adp.add(new ChatMessage(side,chatText.getText().toString()));
        chatText.setText("");
        side = !side;
        return true;
        }
        }

