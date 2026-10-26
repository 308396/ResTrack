-- research_data.sql
-- Sample data for the Research Management Database.

INSERT INTO grant_types (grant_type_name) VALUES
('Fakulti'),
('Universiti <= RM 10,000'),
('Universiti > RM 10,000'),
('INTENSIFICATION OF RESEARCH IN PRIORITY AREAS'),
('AGENSI LUAR (DALAM NEGARA) SWASTA');

INSERT INTO researchers (staff_no, researcher_name) VALUES
(3011, 'DR. AHMAD HAKIM BIN ISMAIL'),
(3012, 'DR. NURUL AIN BINTI HASSAN'),
(3013, 'PROF. MADYA DR. FARID BIN OTHMAN'),
(3014, 'DR. SITI AMINAH BINTI RAHMAN'),
(3015, 'DR. MOHD HAFIZ BIN ZAKARIA'),
(3016, 'DR. NORAZLINA BINTI YUSOF'),
(3017, 'DR. AZMAN BIN IBRAHIM'),
(3018, 'PROF. MADYA DR. KAMAL BIN ABDULLAH'),
(3019, 'DR. FARAH NADIA BINTI OMAR'),
(3020, 'DR. MUHAMMAD FIRDAUS BIN SALLEH');

INSERT INTO research_projects
(research_id, so_code, grant_type_id, research_title, start_date,
 expected_date, end_date, research_status, detail, staff_no)
VALUES
(1, 14501, 1, 'ARTIFICIAL INTELLIGENCE-BASED STUDENT PERFORMANCE PREDICTION SYSTEM', '2022-01-01', '2022-12-31', '2022-12-15', 'Completed - KPI Achieved', NULL, 3011),
(2, 14502, 2, 'DEVELOPMENT OF MOBILE APPLICATION FOR UNIVERSITY STUDENT ATTENDANCE MANAGEMENT', '2022-03-01', '2023-02-28', '2023-02-20', 'Completed - KPI Achieved', NULL, 3012),
(3, 14503, 3, 'MACHINE LEARNING APPROACH FOR EARLY DETECTION OF CYBERSECURITY THREATS', '2022-06-01', '2024-05-31', '2024-05-15', 'Completed - KPI Achieved', NULL, 3013),
(4, 14504, 4, 'SMART AGRICULTURE MONITORING SYSTEM USING INTERNET OF THINGS TECHNOLOGY', '2023-01-01', '2024-12-31', '2024-11-30', 'Completed - KPI Achieved', NULL, 3014),
(5, 14505, 5, 'BLOCKCHAIN-BASED DIGITAL CERTIFICATE VERIFICATION SYSTEM FOR HIGHER EDUCATION', '2023-04-01', '2024-03-31', '2024-03-20', 'Completed - KPI Achieved', NULL, 3015),
(6, 14506, 1, 'USER EXPERIENCE EVALUATION OF ONLINE LEARNING PLATFORMS AMONG UNIVERSITY STUDENTS', '2023-07-01', '2024-06-30', '2024-06-15', 'Completed - KPI Achieved', NULL, 3016),
(7, 14507, 2, 'SENTIMENT ANALYSIS OF SOCIAL MEDIA CONTENT USING NATURAL LANGUAGE PROCESSING', '2024-01-01', '2024-12-31', '2024-12-20', 'Completed - KPI Achieved', NULL, 3017),
(8, 14508, 3, 'CLOUD-BASED MICROSERVICES ARCHITECTURE FOR UNIVERSITY INFORMATION SYSTEMS', '2024-03-01', '2026-02-28', NULL, 'In Progress', NULL, 3018),
(9, 14509, 5, 'DEVELOPMENT OF AN INTELLIGENT FINANCIAL MANAGEMENT SYSTEM FOR SMALL ENTERPRISES', '2025-06-01', '2027-05-31', NULL, 'In Progress', NULL, 3019),
(10, 14510, 4, 'GENERATIVE ARTIFICIAL INTELLIGENCE FOR AUTOMATED SOFTWARE TESTING AND QUALITY ASSURANCE', '2026-01-01', '2027-12-31', NULL, 'In Progress', NULL, 3020);

-- SELECT test
SELECT * FROM research_projects ORDER BY research_id;

-- JOIN test
SELECT rp.research_title, gt.grant_type_name,
       r.researcher_name, rp.research_status
FROM research_projects rp
JOIN grant_types gt ON rp.grant_type_id = gt.grant_type_id
JOIN researchers r ON rp.staff_no = r.staff_no
ORDER BY rp.research_id;

-- UPDATE test; rollback restores the original data
BEGIN;
UPDATE research_projects
SET research_status = 'Test Update'
WHERE research_id = 1;
SELECT research_id, research_title, research_status
FROM research_projects WHERE research_id = 1;
ROLLBACK;

-- DELETE test; rollback restores the deleted record
BEGIN;
DELETE FROM research_projects WHERE research_id = 10;
SELECT COUNT(*) AS project_count_after_test_delete
FROM research_projects;
ROLLBACK;

-- Confirm all 10 sample projects remain
SELECT COUNT(*) AS total_research_projects
FROM research_projects;
