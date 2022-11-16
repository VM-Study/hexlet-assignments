package exercise;

class Address {
    // BEGIN

    // TODO не уверен почему заставило писать @MinLength(minLength = 4), хотя в примере задания пишут просто @MinLength(4)
    @NotNull
    @MinLength(minLength = 4)
    private String country;
    // END

    // BEGIN

    @NotNull
    private String city;
    // END

    // BEGIN

    @NotNull
    private String street;
    // END

    // BEGIN

    @NotNull
    private String houseNumber;
    // END

    private String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}
