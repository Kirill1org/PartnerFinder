package bonch.dev.compagregator.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.List;

import bonch.dev.compagregator.DAO.Company;
import bonch.dev.compagregator.DAO.Tag;
import bonch.dev.compagregator.R;


public class CompaniesRVAdapter extends RecyclerView.Adapter<CompaniesRVAdapter.CompaniesViewHolder> {

    private List<Company> companyList;
    private LayoutInflater inflater;
    private Context context;

    public CompaniesRVAdapter(Context context, List<Company> companyList) {
        this.companyList = companyList;
        this.context = context;
        this.inflater = LayoutInflater.from(context);


    }

    @NonNull
    @Override
    public CompaniesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CompaniesViewHolder(inflater.inflate(R.layout.company_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CompaniesViewHolder holder, int position) {
        holder.bind(companyList.get(position));
    }

    @Override
    public int getItemCount() {
        return companyList.size();
    }


    class CompaniesViewHolder extends RecyclerView.ViewHolder {

        private TextView companyNameTextView;
        private TextView companyCommentTextView;
        private ChipGroup companyTagChips;

        public CompaniesViewHolder(@NonNull View itemView) {
            super(itemView);

            companyNameTextView = itemView.findViewById(R.id.companyNameTextView);
            companyCommentTextView = itemView.findViewById(R.id.companyCommentTextView);
            companyTagChips = itemView.findViewById(R.id.companyTagChips);

        }

        public void bind(Company company) {
            companyNameTextView.setText(company.getName());
            companyCommentTextView.setText(company.getComment());

            for (Tag tag : company.getTags()){
                LayoutInflater inflater = LayoutInflater.from(context);
                final Chip chip = (Chip) inflater.inflate(R.layout.chip_layout, null, false);
                chip.setText(tag.getName());
                chip.setClickable(false);
                companyTagChips.addView(chip);
            }
        }

    }
}
