package bonch.dev.compagregator.ui.CompanyList;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import bonch.dev.compagregator.DAO.Company;
import bonch.dev.compagregator.DAO.CompanyDAO;
import bonch.dev.compagregator.DAO.Tag;
import bonch.dev.compagregator.Network.CompaniesService;
import bonch.dev.compagregator.Network.NetworkModule;
import bonch.dev.compagregator.R;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class CompanyListFragment extends Fragment {

    private CompaniesService api;

    private RecyclerView companiesRV;
    private ChipGroup searchTagCompanies;
    private Button addSearchTagBtn;

    private List<Tag> currentSearchTagList;

    private int companyID;
    private Company currentCompany;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_companies_list, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViews(view);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLists();
        getCurrentCompnay();

    }

    private void getCurrentCompnay() {
        api.getCompanyFromID(companyID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(company -> initCurrentCompany(company), Throwable -> showErrorMessage(Throwable));

    }

    private void initCurrentCompany(CompanyDAO company) {
        //currentSearchTagList = company.getNeedTags()
        /*currentCompany=company;
        ArrayList<Tag> needCompanyArrayListTags = new ArrayList<Tag>();
        needCompanyArrayListTags.addAll(company.getNeed_tags());
        addTagsFromReg(needCompanyArrayListTags);*/
    }

    private void showErrorMessage(Throwable throwable) {
        Toast.makeText(getContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
        Log.e("ERROR GET COMPANY", throwable.getMessage());
    }

    private void addTagsFromReg(ArrayList<Tag> companyFindArrayList) {

        for (Tag tag : companyFindArrayList) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            final Chip chip = (Chip) inflater.inflate(R.layout.chip_layout, null, false);
            chip.setText(tag.getName());
            chip.setOnCloseIconClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    searchTagCompanies.removeView(view);
                    deleteChipFromSearch(chip.getText().toString());

                }
            });
            chip.setClickable(false);
            searchTagCompanies.addView(chip);
        }
    }

    private void deleteChipFromSearch(String tagTitle) {
        int deleteTagID = -1;

        for (int i = 0; i < currentCompany.getNeed_tags().size(); i++) {
            if (currentCompany.getNeed_tags().get(i).getName().equals(tagTitle)) deleteTagID = i;
        }
       // currentCompany.getresultFindListTags.remove(deleteTagID);

    }

    private void initLists() {

        companyID = getActivity().getIntent().getExtras().getInt("companyID", 0);
        api = new NetworkModule().tagsService;


        /*companiesRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        companiesRV.setAdapter(new CompaniesRVAdapter(getActivity(), companyArrayList));*/
    }

    private void initViews(View view) {
        companiesRV = view.findViewById(R.id.companiesRecyclerView);
        searchTagCompanies = view.findViewById(R.id.companySearchTagGroup);
        addSearchTagBtn = view.findViewById(R.id.addSearchTagBtn);

    }
}