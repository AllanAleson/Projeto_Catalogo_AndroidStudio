package br.gov.sp.cps.catalogoproduto;

public class NotebookActivity extends ProductDetailActivity {
    @Override protected int getProductImageResource() { return R.drawable.notebook; }
    @Override protected int getProductNameResource() { return R.string.notebook_name; }
    @Override protected int getProductDescriptionResource() { return R.string.notebook_description; }
    @Override protected int getProductInformationResource() { return R.string.notebook_information; }
}
