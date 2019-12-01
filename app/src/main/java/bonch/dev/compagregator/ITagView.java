package bonch.dev.compagregator;

import com.arellomobile.mvp.MvpView;

import java.util.ArrayList;


import bonch.dev.compagregator.DAO.Tag;

public interface ITagView extends MvpView {

    void showProgressBar();
    void hideProgressBar();
    void showErrorMessage(Throwable e);
    void startSearchActivity(int companyID);

}
