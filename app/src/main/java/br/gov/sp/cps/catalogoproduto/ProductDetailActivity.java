package br.gov.sp.cps.catalogoproduto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class ProductDetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        ImageView productImage = findViewById(R.id.image_product_detail);
        TextView productName = findViewById(R.id.text_product_name);
        TextView productDescription = findViewById(R.id.text_product_description);
        TextView productInformation = findViewById(R.id.text_product_information);
        Button backButton = findViewById(R.id.button_back);

        productImage.setImageResource(getProductImageResource());
        productImage.setContentDescription(getString(getProductNameResource()));
        productName.setText(getProductNameResource());
        productDescription.setText(getProductDescriptionResource());
        productInformation.setText(getProductInformationResource());
        backButton.setOnClickListener(view -> finish());
    }

    protected abstract int getProductImageResource();
    protected abstract int getProductNameResource();
    protected abstract int getProductDescriptionResource();
    protected abstract int getProductInformationResource();
}
