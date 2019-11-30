package bonch.dev.compagregator.Network;

import java.util.List;

import bonch.dev.compagregator.DAO.Company;
import bonch.dev.compagregator.DAO.Tag;
import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface TagsService {
    @GET("tags")
    Single<List<Tag>> getTagsList();

    @POST("companies")
    Single<ResponseBody> postCompany(@Body Company company);

}
