/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package overflowrocks;

public class ZipCodeSuxException extends RuntimeException {

    ZipCodeSuxException(String zip_codes_are_5_digits) {
        super(zip_codes_are_5_digits);
    }
}
