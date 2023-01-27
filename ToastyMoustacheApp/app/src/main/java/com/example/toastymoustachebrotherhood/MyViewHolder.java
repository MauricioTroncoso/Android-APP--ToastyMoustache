package com.example.toastymoustachebrotherhood;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentSnapshot;

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView textviewname,textviewdescripcion,textviewtipo;
    ImageView cardimg;
    CardView cv2;
    private OnItemCliclListener listener;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        cv2=itemView.findViewById(R.id.cv2);
        cardimg= itemView.findViewById(R.id.imgcard);
        textviewtipo= itemView.findViewById(R.id.textviewtipo);
        textviewname=itemView.findViewById(R.id.textviewname);
        textviewdescripcion=itemView.findViewById(R.id.textviewdescripcion);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position= getAbsoluteAdapterPosition();
                if (position != RecyclerView.NO_POSITION && listener !=null){

                }
            }
        });

    }
    public interface OnItemCliclListener{
        void onItemClick(DocumentSnapshot documentSnapshot, int position);

    }
    public void setOnItemClickListener(OnItemCliclListener listener){
        this.listener=listener;
    }
}
