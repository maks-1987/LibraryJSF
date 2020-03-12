package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;

@FacesValidator("validators.LoginValidator")
public class LoginValidator implements Validator {
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value) throws ValidatorException {
        if (value.toString().length() < 5) {
            ResourceBundle resourceBundle = ResourceBundle.getBundle("nls.message",
                    FacesContext.getCurrentInstance().getViewRoot().getLocale());
            FacesMessage facesMessage = new FacesMessage(resourceBundle.getString("login_length_error"));
            facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(facesMessage);
        }
    }
}
