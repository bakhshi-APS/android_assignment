package pune.sicsr.assignment_tasks.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import pune.sicsr.assignment_tasks.R;
import pune.sicsr.assignment_tasks.model.Fruit;

public class CustomRecyclerAdapter extends
        RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<Fruit> fruitUtils;

    public CustomRecyclerAdapter(Context context, List fruitUtils) {
        this.context = context;
        this.fruitUtils = fruitUtils;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.single_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(fruitUtils.get(position));

        Fruit fruit = fruitUtils.get(position);

        holder.fruitName.setText(fruit.getFruitName());
        holder.fruitId.setText(String.valueOf(fruit.getFruitId()));

    }

    @Override
    public int getItemCount() {
        return fruitUtils.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView fruitName;
        public TextView fruitId;

        public ViewHolder(View itemView) {
            super(itemView);

            fruitName = (TextView) itemView.findViewById(R.id.fruit_name);
            fruitId = (TextView) itemView.findViewById(R.id.fruit_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Fruit fruit = (Fruit) view.getTag();
                    Toast.makeText(view.getContext(), fruit.getFruitName() + ":" + fruit.getFruitId(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

}