package com.mycompany.lab5.controller;

import com.mycompany.lab5.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class FormController {
    @FXML private TextField nameField;
    @FXML private TextField ageField;
    @FXML private TextField emailField;

    @FXML
    private void handleSubmit() {
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String email = emailField.getText().trim();

        StringBuilder errors = new StringBuilder();

        if (name.isEmpty()) {
            errors.append("- Name cannot be empty.\n");
        } else if (!name.matches("[\\p{L} .'-]+")) {
            errors.append("- Name can only contain letters and spaces.\n");
        }

        int age = 0;
        if (ageText.isEmpty()) {
            errors.append("- Age cannot be empty.\n");
        } else {
            try {
                age = Integer.parseInt(ageText);
                if (age < 1 || age > 120) {
                    errors.append("- Age must be between 1 and 120.\n");
                }
            } catch (NumberFormatException e) {
                errors.append("- Age must be a whole number.\n");
            }
        }

        if (email.isEmpty()) {
            errors.append("- Email cannot be empty.\n");
        } else if (!email.matches("^[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+$")) {
            errors.append("- Email format is invalid.\n");
        }

        if (errors.length() > 0) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", errors.toString());
            return;
        }

        Person person = new Person(name, age, email);
        showAlert(Alert.AlertType.INFORMATION, "Submitted",
                "Name: " + person.getName() + "\n"
                + "Age: " + person.getAge() + "\n"
                + "Email: " + person.getEmail());
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
