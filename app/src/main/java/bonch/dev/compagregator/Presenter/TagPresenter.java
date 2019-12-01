package bonch.dev.compagregator.Presenter;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.ArrayList;
import java.util.List;

import bonch.dev.compagregator.DAO.Company;
import bonch.dev.compagregator.DAO.Tag;
import bonch.dev.compagregator.Network.NetworkModule;
import bonch.dev.compagregator.Network.CompaniesService;
import bonch.dev.compagregator.ITagView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class TagPresenter extends MvpPresenter<ITagView> implements ITagPresenter {

    private CompaniesService api;

    private ArrayList<String> titleListTags;
    private ArrayList<Tag> objectListTags;
    private List<Tag> resultCompanyListTags;
    private List<Tag> resultFindListTags;

    private void init() {

        titleListTags = new ArrayList<String>();
        objectListTags = new ArrayList<Tag>();
        resultCompanyListTags = new ArrayList<Tag>();
        resultFindListTags = new ArrayList<Tag>();

        api = new NetworkModule().tagsService;
    }


    @Override
    public void getTagListFromAPI() {
        init();

        api.getTagsList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::addToFullTagsList, Throwable -> getViewState().showErrorMessage(Throwable));
    }

    @Override
    public List<Tag> getResultCompanyTag() {
        return resultCompanyListTags;
    }

    @Override
    public List<Tag> getResultFindTag() {
        return resultFindListTags;

    }

    @Override
    public ArrayList<String> getTitleListTag() {
        return titleListTags;
    }

    @Override
    public Tag getTagFromPosition(int position) {
        return objectListTags.get(position);
    }

    @Override
    public void addCompanyTag(Tag addCompanyTag) {
        resultCompanyListTags.add(addCompanyTag);

    }

    @Override
    public void addFindTag(Tag addFindTag) {
        resultFindListTags.add(addFindTag);

    }

    @Override
    public void deleteCompanyTag(String tagTitle) {
       int deleteTagID=-1;

        for (int i=0; i<resultCompanyListTags.size(); i++){
            if (resultCompanyListTags.get(i).getName().equals(tagTitle)) deleteTagID=i;
        }
        resultCompanyListTags.remove(deleteTagID);
    }

    @Override
    public void deleteFindTag(String tagTitle) {
        int deleteTagID=-1;

        for (int i=0; i<resultFindListTags.size(); i++){
            if (resultFindListTags.get(i).getName().equals(tagTitle)) deleteTagID=i;
        }
        resultFindListTags.remove(deleteTagID);

    }

    @Override
    public void regCompany(Company company) {

            api.postCompany(company)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(resopnseBody -> startMainActivity(resopnseBody.getID()), Throwable -> getViewState().showErrorMessage(Throwable));


    }

    private void startMainActivity(int companyID) {
        getViewState().startSearchActivity(companyID);
    }


    private void addToFullTagsList(List<Tag> tags) {

        objectListTags.addAll(tags);

        for (Tag tag : objectListTags) {
            titleListTags.add(tag.getName());
        }


    }
}
