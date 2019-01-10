package _1901._10;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Travel {

    public static String travel(String r, String zipcode) {
        List<String> addressList = Arrays.stream(r.split(","))
                .filter(address -> zipcode.equals(getZipcode(address)))
                .collect(Collectors.toList());

        StringBuilder result = new StringBuilder(zipcode + ":");

        StringJoiner joiner = new StringJoiner(",");

        for (int i = 0, loop = addressList.size(); i < loop; i++) {
            joiner.add(getStreetAndTown(addressList.get(i)));
        }

        result.append(joiner.toString());
        result.append("/");

        joiner = new StringJoiner(",");

        for (int i = 0, loop = addressList.size(); i < loop; i++) {
            joiner.add(getHouseNumber(addressList.get(i)));
        }

        result.append(joiner.toString());

        return result.toString();
    }

    public static String getZipcode(String address) {
        String[] addressArray = address.split(" ");
        return addressArray[addressArray.length - 2] + " " + addressArray[addressArray.length - 1];
    }

    public static String getStreetAndTown(String address) {
        StringJoiner streetAndTown = new StringJoiner(" ");
        String[] addressArray = address.split(" ");

        for (int i = 1, loop = addressArray.length; i < loop - 2; i++) {
            streetAndTown.add(addressArray[i]);
        }

        return streetAndTown.toString();
    }

    public static String getHouseNumber(String address) {
        return address.split(" ")[0];
    }
}
