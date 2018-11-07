package com.rakesh.librarymanagementsystem.domain;

/**
 *
 * @author Rakesh
 */
public class Book
{
    private String id;
    private String name;
    private String author;
    private String status;
    private String issued_to;
    private String issue_date;
    private String expected_return_date;
    private String issued_by;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getIssued_to()
    {
        return issued_to;
    }

    public void setIssued_to(String issued_to)
    {
        this.issued_to = issued_to;
    }

    public String getIssue_date()
    {
        return issue_date;
    }

    public void setIssue_date(String issue_date)
    {
        this.issue_date = issue_date;
    }

    public String getExpected_return_date()
    {
        return expected_return_date;
    }

    public void setExpected_return_date(String expected_return_date)
    {
        this.expected_return_date = expected_return_date;
    }

    public String getIssued_by()
    {
        return issued_by;
    }

    public void setIssued_by(String issued_by)
    {
        this.issued_by = issued_by;
    }

}
