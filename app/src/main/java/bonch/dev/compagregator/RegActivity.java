package bonch.dev.compagregator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import bonch.dev.compagregator.DAO.Tag;

import bonch.dev.compagregator.Presenter.TagPresenter;
import in.galaxyofandroid.spinerdialog.OnSpinerItemClick;
import in.galaxyofandroid.spinerdialog.SpinnerDialog;


public class RegActivity extends MvpAppCompatActivity implements ITagView {

    @InjectPresenter
    TagPresenter mTagPresenter;

    private Button regBtn;
    private CheckBox checkCompanyHidden;

    private EditText companyName;
    private EditText companyAddition;
    private EditText companyEmail;

    private ChipGroup companyTags;
    private ChipGroup findTags;

    private FloatingActionButton addCompanyTagBtn;
    private FloatingActionButton addFindTagBtn;

    private SpinnerDialog addCompanyTagDialog;
    private SpinnerDialog addFindTagDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        mTagPresenter.getTagListFromAPI();
        init();
        setListeners();

    }

    private void addCompanyTag(String tagTitle, int tagPosition) {
        LayoutInflater inflater = LayoutInflater.from(RegActivity.this);
        final Chip chip = (Chip) inflater.inflate(R.layout.chip_layout, null, false);
        chip.setText(tagTitle);
        chip.setClickable(false);

        chip.setOnCloseIconClickListener(view -> {
            companyTags.removeView(view);
            mTagPresenter.deleteCompanyTag(chip.getText().toString());

        });
        mTagPresenter.addCompanyTag(mTagPresenter.getTagFromPosition(tagPosition));

        companyTags.addView(chip);
    }

    private void addFindTag(String tagTitle, int tagPosition) {
        LayoutInflater inflater = LayoutInflater.from(RegActivity.this);
        final Chip chip = (Chip) inflater.inflate(R.layout.chip_layout, null, false);
        chip.setText(tagTitle);
        chip.setId(tagPosition);

        chip.setOnCloseIconClickListener(view -> {
            companyTags.removeView(view);
            mTagPresenter.deleteFindTag(chip.getText().toString());
        });

        mTagPresenter.addFindTag(mTagPresenter.getTagFromPosition(tagPosition));

        findTags.addView(chip);
    }

    private void setListeners() {
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Company company = new Company(companyName.getText().toString(), companyAddition.getText().toString(),
                        companyEmail.getText().toString(), checkCompanyHidden.isChecked(), mTagPresenter.getResultCompanyTag(), mTagPresenter.getResultFindTag());

                api.postCompany(company)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(resopnseBody -> showResponseCode(resopnseBody), Throwable -> showThrowableMessage(Throwable));
*/

            }
        });

        addCompanyTagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCompanyTagDialog.showSpinerDialog();

            }
        });

        addFindTagBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFindTagDialog.showSpinerDialog();

            }
        });

        addCompanyTagDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String titleTag, int positionTag) {
                addCompanyTag(titleTag, positionTag);
            }
        });
        addFindTagDialog.bindOnSpinerListener(new OnSpinerItemClick() {
            @Override
            public void onClick(String titleTag, int positionTag) {
                addFindTag(titleTag, positionTag);
            }
        });
    }


    private void init() {
        companyTags = findViewById(R.id.companyTagGroup);
        findTags = findViewById(R.id.findTagGroup);
        regBtn = findViewById(R.id.reg_btn);

        addCompanyTagBtn = findViewById(R.id.floatingAddCompanyTagBtn);
        addFindTagBtn = findViewById(R.id.floatingAddFindTagBtn);

        companyName = findViewById(R.id.companyName);
        companyAddition = findViewById(R.id.companyAdditionInfo);
        companyEmail = findViewById(R.id.companyEmail);

        checkCompanyHidden = findViewById(R.id.companyCheckVisible);

        addCompanyTagDialog = new SpinnerDialog(RegActivity.this, mTagPresenter.getTitleListTag(), "Add company tag");
        addFindTagDialog = new SpinnerDialog(RegActivity.this, mTagPresenter.getTitleListTag(), "Add find tag");


    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showErrorMessage(Throwable e) {
        Toast.makeText(this, e.getLocalizedMessage().toString(), Toast.LENGTH_LONG).show();

    }

    @Override
    public void startSearchActivity(List<Tag> resultFindListTag) {

    }
}
