package descarteseletivo2.fabiolindemberg.com.br.pocascommyco2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class TopButtonEventReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("Top Button", "Ok");
    }
}
