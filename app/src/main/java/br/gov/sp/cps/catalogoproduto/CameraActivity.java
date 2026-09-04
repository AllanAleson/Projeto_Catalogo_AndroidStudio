package br.gov.sp.cps.catalogoproduto;

public class CameraActivity extends ProductDetailActivity {
    @Override protected int getProductImageResource() { return R.drawable.camera; }
    @Override protected int getProductNameResource() { return R.string.camera_name; }
    @Override protected int getProductDescriptionResource() { return R.string.camera_description; }
    @Override protected int getProductInformationResource() { return R.string.camera_information; }
}
