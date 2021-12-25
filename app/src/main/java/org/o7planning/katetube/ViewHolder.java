package org.o7planning.katetube;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView comment;

    public ViewHolder (View itemView) {

         super(itemView);
         comment = itemView.findViewById(R.id.text_view_massage);

    }
}
