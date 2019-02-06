package descarteseletivo2.fabiolindemberg.com.br.pocascommyco2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ascom.myco.barcodescanner.ScanResult;
import com.ascom.myco.barcodescanner.ScannerRequest;

import static com.ascom.myco.barcodescanner.ScannerRequest.CancelReason.INVALID_LICENSE;
import static com.ascom.myco.barcodescanner.ScannerRequest.CancelReason.UNKNOWN_ERROR;
import static com.ascom.myco.barcodescanner.ScannerRequest.CancelReason.USER_CANCELED;

public class MainActivity extends AppCompatActivity implements ScannerRequest.Delegate {

    private ScannerRequest scannerRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnScan = (Button) findViewById(R.id.btn_scan);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scannerRequest = new ScannerRequest();
                scannerRequest.start(view.getContext(), (ScannerRequest.Delegate) view.getContext());

            }
        });

    }

    @Override
    public void onScannerResult(ScanResult scanResult) {
        Log.d("Scarnner Result", scanResult.getBarcodeData().toString());
    }

    @Override
    public void onScannerCanceled(int i) {
        switch (i){
            case INVALID_LICENSE:
                Log.d("Cancel Reason", "Licença inválida!");
                break;
            case UNKNOWN_ERROR:
                Log.d("Cancel Reason", "Erro desconhecido!");
                break;
            case USER_CANCELED:
                Log.d("Cancel Reason", "Cancelado pelo usuário!");
                break;
        }
    }
}
