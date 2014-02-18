CREATE TABLE [dbo].[Table]
(
	[StudentNumber] INT NOT NULL PRIMARY KEY IDENTITY(123456, 1), 
    [FirstName] NVARCHAR(50) NOT NULL, 
    [LastName] NVARCHAR(50) NOT NULL, 
    [Gpa] REAL NULL, 
    [GraduationYear] INT NULL, 
    [PhoneNumber] NCHAR(10) NULL, 
    [Email] NVARCHAR(50) NULL
)
