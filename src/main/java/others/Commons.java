package others;

public class Commons {
    public static void main(String[] args) {
        String locatorCommon = "//span[contains(text(),'%s')]/parent::label/preceding-sibling::button/'%s'";
        String workPlaceLocator = String.format(locatorCommon,"WorkPlace", "Document");
        System.out.println("WorkPlace = " + workPlaceLocator);

    }

}
