package br.gov.sp.cps.catalogoproduto;

public class HeadphonesActivity extends ProductDetailActivity {
    @Override protected int getProductImageResource() { return R.drawable.fone; }
    @Override protected int getProductNameResource() { return R.string.headphones_name; }
    @Override protected int getProductDescriptionResource() { return R.string.headphones_description; }
    @Override protected int getProductInformationResource() { return R.string.headphones_information; }
}
