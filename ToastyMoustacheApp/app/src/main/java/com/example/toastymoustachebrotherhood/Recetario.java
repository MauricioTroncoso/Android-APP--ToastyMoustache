package com.example.toastymoustachebrotherhood;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class Recetario extends AppCompatActivity {
    private DatabaseReference db;
    private FirebaseFirestore db2 = FirebaseFirestore.getInstance();
    private RecyclerView list1;

    //private FirebaseRecyclerOptions<recetas> receta;
    //private FirebaseRecyclerAdapter<recetas,MyViewHolder> adapter;
    private adapter adapterR;

ArrayList<recetas> myReceta = new ArrayList<recetas>();

RequestQueue caleuche;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetario);

        list1 = (RecyclerView) findViewById(R.id.list1);

        caleuche= Volley.newRequestQueue(this);
        list1.setLayoutManager(new LinearLayoutManager(this));
        db=FirebaseDatabase.getInstance().getReference();
        myReceta= new ArrayList<>();
         adapterR = new adapter(myReceta,R.layout.card2);
         list1.setAdapter(adapterR);

            getAlgo();
    }

    private void getAlgo(){
         //Traer todos los postres
        db2.collection("Recetas").document("Postres").collection("Carlota de Limon").document("Carlota de Limon").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){

                            String nombre= documentSnapshot.get("nombre").toString();
                            String descripcion= documentSnapshot.get("descripcion").toString();
                            String tipo= documentSnapshot.get("tipo").toString();
                            myReceta.add(new recetas(nombre,descripcion,tipo));


                        }else{
                            Toast.makeText(Recetario.this, "Algo paso", Toast.LENGTH_SHORT).show();
                        }
                        adapterR.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

            //Traer todos las Comidas

        db2.collection("Recetas").document("Comida").collection("Arroz").document("Arroz").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){

                            String nombre= documentSnapshot.get("nombre").toString();
                            String descripcion= documentSnapshot.get("descripcion").toString();
                            String tipo= documentSnapshot.get("tipo").toString();
                            myReceta.add(new recetas(nombre,descripcion,tipo));



                        }else{
                            Toast.makeText(Recetario.this, "Algo paso", Toast.LENGTH_SHORT).show();
                        }

                        adapterR.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

    }


    public void readPostres(View view){
    myReceta.clear();
         db2.collection("Recetas").document("Postres").collection("Carlota de Limon").document("Carlota de Limon").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                     @Override
                     public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){

                            String nombre= documentSnapshot.get("nombre").toString();
                            String descripcion= documentSnapshot.get("descripcion").toString();
                            String tipo= documentSnapshot.get("tipo").toString();
                            myReceta.add(new recetas(nombre,descripcion,tipo));


                        }else{
                            Toast.makeText(Recetario.this, "Algo paso", Toast.LENGTH_SHORT).show();
                        }
                        adapterR.notifyDataSetChanged();
                     }
                 })
                 .addOnFailureListener(new OnFailureListener() {
                     @Override
                     public void onFailure(@NonNull Exception e) {

                     }
                 });


    }
    public void readComida(View view){
    myReceta.clear();

        db2.collection("Recetas").document("Comida").collection("Arroz").document("Arroz").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if(documentSnapshot.exists()){
                            String nombre= documentSnapshot.get("nombre").toString();
                            String descripcion= documentSnapshot.get("descripcion").toString();
                            String tipo= documentSnapshot.get("tipo").toString();
                            myReceta.add(new recetas(nombre,descripcion,tipo));

                            

                        }else{
                            Toast.makeText(Recetario.this, "Algo paso", Toast.LENGTH_SHORT).show();
                        }

                    adapterR.notifyDataSetChanged();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });



    }
    public void traerTodo(View view){
         myReceta.clear();
         getAlgo();
    }
    public void volver(View view){
        Intent volverMenu=new Intent(this,MainActivity.class);
        startActivity(volverMenu);
    }

}
