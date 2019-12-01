package bonch.dev.compagregator.Network;

import com.google.gson.Gson;

import org.json.JSONObject;
import org.json.JSONStringer;

import java.util.List;

import bonch.dev.compagregator.DAO.Company;
import bonch.dev.compagregator.DAO.CompanyDAO;
import bonch.dev.compagregator.DAO.Tag;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface CompaniesService {
    @GET("tags")
    Single<List<Tag>> getTagsList();

    @GET("companies/")
    Single<CompanyDAO> getCompanyFromID(@Query("id") int id);

    @POST("companies")
    Single<Company> postCompany(@Body Company company);

}
