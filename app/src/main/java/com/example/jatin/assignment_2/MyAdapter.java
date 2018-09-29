package com.example.jatin.assignment_2;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final LayoutInflater mInflater;
    private final List<Grocery> groceries;


    public  class MyViewHolder extends RecyclerView.ViewHolder {

        public String[] prods = {"Apple", "Mango", "Pineapple"};
        public TextView prodName;
        public ImageView prodImage;
        public TextView prodPrice;
        public TextView prodWeight;
        public TextView prodQuantity;
        public CardView cardView;

        public MyAdapter mAdapter;

        public MyViewHolder(final View itemView, MyAdapter mAdapter) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            prodName = itemView.findViewById(R.id.prodName);
            prodImage = itemView.findViewById(R.id.prodImg);
            prodPrice = itemView.findViewById(R.id.prodValue);
            prodWeight = itemView.findViewById(R.id.prodWeight);
            prodQuantity = itemView.findViewById(R.id.prodQuantity);

            this.mAdapter = mAdapter;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {Toast.makeText(itemView.getContext(), prods[getAdapterPosition()], Toast.LENGTH_LONG).show();}
            });

        }
    }


    public MyAdapter(Context context, List<Grocery> groceries){
        mInflater = LayoutInflater.from(context);
        this.groceries = groceries;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.list_activity, parent, false);
        return new MyAdapter.MyViewHolder(itemView, this);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.prodName.setText(groceries.get(position).productName);
        holder.prodImage.setImageResource(groceries.get(position).productImage);
        holder.prodPrice.setText(groceries.get(position).getProductPrice());
        holder.prodWeight.setText(groceries.get(position).getProductWeight());
        holder.prodQuantity.setText(groceries.get(position).getProductQty());
    }


    @Override
    public int getItemCount() {
       return groceries.size();

    }
}
