package br.gov.sp.cps.catalogoproduto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final String STATE_SELECTED_PRODUCT = "selected_product";
    private static final int NO_PRODUCT = 0;
    private static final int PRODUCT_HEADPHONES = 1;
    private static final int PRODUCT_CAMERA = 2;
    private static final int PRODUCT_NOTEBOOK = 3;

    private ImageView featuredImage;
    private ImageView headphonesThumbnail;
    private ImageView cameraThumbnail;
    private ImageView notebookThumbnail;
    private TextView selectedProductText;
    private Button detailsButton;
    private Button clearButton;
    private int selectedProduct = NO_PRODUCT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        featuredImage = findViewById(R.id.image_featured);
        headphonesThumbnail = findViewById(R.id.image_headphones);
        cameraThumbnail = findViewById(R.id.image_camera);
        notebookThumbnail = findViewById(R.id.image_notebook);
        selectedProductText = findViewById(R.id.text_selected_product);
        detailsButton = findViewById(R.id.button_details);
        clearButton = findViewById(R.id.button_clear);

        headphonesThumbnail.setOnClickListener(view -> selectProduct(PRODUCT_HEADPHONES));
        cameraThumbnail.setOnClickListener(view -> selectProduct(PRODUCT_CAMERA));
        notebookThumbnail.setOnClickListener(view -> selectProduct(PRODUCT_NOTEBOOK));
        detailsButton.setOnClickListener(view -> openSelectedProductDetails());
        clearButton.setOnClickListener(view -> clearSelection());

        if (savedInstanceState != null) {
            selectedProduct = savedInstanceState.getInt(STATE_SELECTED_PRODUCT, NO_PRODUCT);
        }
        updateScreen();
    }

    private void selectProduct(int product) {
        selectedProduct = product;
        updateScreen();
    }

    private void clearSelection() {
        selectedProduct = NO_PRODUCT;
        updateScreen();
        Toast.makeText(this, R.string.selection_cleared, Toast.LENGTH_SHORT).show();
    }

    private void updateScreen() {
        resetThumbnailBackgrounds();

        switch (selectedProduct) {
            case PRODUCT_HEADPHONES:
                showSelectedProduct(R.drawable.fone, R.string.headphones_name, headphonesThumbnail);
                break;
            case PRODUCT_CAMERA:
                showSelectedProduct(R.drawable.camera, R.string.camera_name, cameraThumbnail);
                break;
            case PRODUCT_NOTEBOOK:
                showSelectedProduct(R.drawable.notebook, R.string.notebook_name, notebookThumbnail);
                break;
            default:
                featuredImage.setImageResource(R.drawable.product_placeholder);
                featuredImage.setContentDescription(getString(R.string.no_product_selected));
                selectedProductText.setText(R.string.choose_product);
                detailsButton.setEnabled(false);
                clearButton.setEnabled(false);
                break;
        }
    }

    private void showSelectedProduct(int imageResource, int nameResource, ImageView thumbnail) {
        String productName = getString(nameResource);
        featuredImage.setImageResource(imageResource);
        featuredImage.setContentDescription(productName);
        selectedProductText.setText(productName);
        thumbnail.setBackgroundResource(R.drawable.thumbnail_selected);
        detailsButton.setEnabled(true);
        clearButton.setEnabled(true);
    }

    private void resetThumbnailBackgrounds() {
        headphonesThumbnail.setBackgroundResource(R.drawable.thumbnail_background);
        cameraThumbnail.setBackgroundResource(R.drawable.thumbnail_background);
        notebookThumbnail.setBackgroundResource(R.drawable.thumbnail_background);
    }

    private void openSelectedProductDetails() {
        Class<?> destination;
        switch (selectedProduct) {
            case PRODUCT_HEADPHONES:
                destination = HeadphonesActivity.class;
                break;
            case PRODUCT_CAMERA:
                destination = CameraActivity.class;
                break;
            case PRODUCT_NOTEBOOK:
                destination = NotebookActivity.class;
                break;
            default:
                Toast.makeText(this, R.string.select_before_details, Toast.LENGTH_SHORT).show();
                return;
        }
        startActivity(new Intent(this, destination));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SELECTED_PRODUCT, selectedProduct);
        super.onSaveInstanceState(outState);
    }
}
