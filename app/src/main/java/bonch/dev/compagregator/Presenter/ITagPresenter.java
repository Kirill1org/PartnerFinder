package bonch.dev.compagregator.Presenter;

import java.util.ArrayList;
import java.util.List;

import bonch.dev.compagregator.DAO.Company;
import bonch.dev.compagregator.DAO.Tag;

public interface ITagPresenter {
    void getTagListFromAPI();
    List<Tag> getResultCompanyTag();
    List<Tag> getResultFindTag();
    ArrayList<String> getTitleListTag();
    Tag getTagFromPosition(int position);
    void addCompanyTag(Tag addCompanyTag);
    void addFindTag(Tag addFindTag);
    void deleteCompanyTag(String tagTitle);
    void deleteFindTag(String tagTitle);
    void regCompany(Company company);
}
