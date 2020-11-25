package ru.geekbrains.lesson5;

import org.hibernate.exception.SQLGrammarException;
import ru.geekbrains.controller.ProductController;

import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "categoryConverter")
public class CategoryConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String categoryId) {
        if (categoryId == null){throw new NullPointerException("string(asObject)");}
        if (facesContext == null){throw new NullPointerException("context(asObject)");}
        if (uiComponent == null){throw new NullPointerException("component(asObject)");}
        FacesContext ctx = FacesContext.getCurrentInstance();
        ValueExpression vex =
                ctx.getApplication().getExpressionFactory()
                        .createValueExpression(ctx.getELContext(),
                                "#{productController}", ProductController.class);
        ProductController pc = (ProductController) vex.getValue(ctx.getELContext());
        Category c = pc.getCategory(Integer.valueOf(categoryId));
        if(c!=null){
            return c;
        } else throw new NullPointerException("object is null(asObject)");
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object category){
        if (facesContext == null){throw new NullPointerException("context(asString)");}
        if (uiComponent == null){throw new NullPointerException("component(asString)");}
        String s = null;
        try{
            s = ((Category) category).getId().toString();
            return s;
        }catch (NullPointerException e){
            return null;
        }
//        if(s!=null){
//            return s;
//        } else return "1";
    }
}
