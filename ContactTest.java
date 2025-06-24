public class ContactTest {
    public static void main(String[] args) {
        testValidContactCreation();
        testInvalidContactId();
        testSettersValidation();
    }

    private static void testValidContactCreation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        boolean passed = "12345".equals(contact.getContactId()) &&
                         "John".equals(contact.getFirstName()) &&
                         "Doe".equals(contact.getLastName()) &&
                         "1234567890".equals(contact.getPhone()) &&
                         "123 Main St".equals(contact.getAddress());
        System.out.println("testValidContactCreation: " + (passed ? "PASSED" : "FAILED"));
    }

    private static void testInvalidContactId() {
        try {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
            System.out.println("testInvalidContactId: FAILED");
        } catch (IllegalArgumentException e) {
            System.out.println("testInvalidContactId: PASSED");
        }
    }

    private static void testSettersValidation() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        boolean passed = true;

        try {
            contact.setFirstName(null);
            passed = false;
        } catch (IllegalArgumentException e) {}

        try {
            contact.setPhone("123");
            passed = false;
        } catch (IllegalArgumentException e) {}

        contact.setAddress("New Address");
        passed = passed && "New Address".equals(contact.getAddress());

        System.out.println("testSettersValidation: " + (passed ? "PASSED" : "FAILED"));
    }
}
