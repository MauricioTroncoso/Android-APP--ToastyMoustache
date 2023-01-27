package com.example.toastymoustachebrotherhood;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class adapter extends RecyclerView.Adapter<adapter.ViewHolder> {

private int resource;
private ArrayList<recetas> rec;
private Context context;


public interface OnItemClickListener{
    void OnItemClicListener(recetas item);


}
public adapter(ArrayList<recetas> rec,int resource){
    this.rec=rec;
    this.resource=resource;

}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card2,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        recetas receta= rec.get(position);
        //holder.cv2.setAnimation(AnimationUtils.loadAnimation(context,R.anim.cardanim));
        holder.txtname.setText(receta.getNombre());
        holder.txtdescripcion.setText(receta.getDescripcion());
        holder.txttipo.setText(receta.getTipo());

    }

    @Override
    public int getItemCount() {
        return rec.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        ImageView icono;
        CardView cv2;
        private TextView txtname,txtdescripcion,txttipo;
        public View view;
        recetas receta;
       public ViewHolder(View view){
           super(view);
            this.cv2 = (CardView) view.findViewById(R.id.cv2);
            this.icono=(ImageView) view.findViewById(R.id.imgcard);
            this.view=view;
            this.txtname=(TextView) view.findViewById(R.id.textviewname);
            this.txtdescripcion=(TextView) view.findViewById(R.id.textviewdescripcion);
            this.txttipo=(TextView) view.findViewById(R.id.textviewtipo);


       }
    }
}
