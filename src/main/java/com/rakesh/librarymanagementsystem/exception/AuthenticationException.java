package com.rakesh.librarymanagementsystem.exception;

/**
 *
 * @author Rakesh Kuchana
 */
public class AuthenticationException extends Exception
{
    private final String errorMessage;
    
    public AuthenticationException(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    
    @Override
    public String toString()
    {
        return errorMessage;
    }
}
