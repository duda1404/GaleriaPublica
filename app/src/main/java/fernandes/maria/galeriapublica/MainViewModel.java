package fernandes.maria.galeriapublica;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {

    //Dado do tipo inteiro que guarda a opção escolhida pelo usuário no menu btNav
    int navigationOpSelected = R.id.gridViewOp;

    public MainViewModel(@NonNull Application application) {
        super(application);
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

