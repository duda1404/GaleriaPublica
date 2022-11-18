package fernandes.maria.galeriapublica;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import androidx.paging.Pager;
import androidx.paging.PagingConfig;
import androidx.paging.PagingData;
import androidx.paging.PagingLiveData;

import kotlinx.coroutines.CoroutineScope;

public class MainViewModel extends AndroidViewModel {

    LiveData<PagingData<ImageData>> pageLv;

    public LiveData<PagingData<ImageData>> getPageLv() {
        return pageLv;
    }

    //Dado do tipo inteiro que guarda a opção escolhida pelo usuário no menu btNav
    int navigationOpSelected = R.id.gridViewOp;

    public MainViewModel(@NonNull Application application) {
        super(application);
        GalleryRepository galleryRepository = new GalleryRepository(application);
        GalleryPagingSource galleryPagingSource = new GalleryPagingSource(galleryRepository);
        Pager<Integer, ImageData> pager = new Pager(new PagingConfig(10), () -> galleryPagingSource);
        CoroutineScope viewModelScope = ViewModelKt.getViewModelScope(this);
        pageLv = PagingLiveData.cachedIn(PagingLiveData.getLiveData(pager), viewModelScope);
    }

    //Pega o valor de navigationOpSelected
    public int getNavigationOpSelected() {
        return navigationOpSelected;
    }

    //Seta o valor de navigationOpSelected
    public void setNavigationOpSelected(int navigationOpSelected) {
        this.navigationOpSelected = navigationOpSelected;
    }
}

