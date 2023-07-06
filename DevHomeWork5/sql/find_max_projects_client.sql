SELECT MAX(project_count)
    FROM (
        SELECT COUNT(p.ID) AS project_count
        FROM client c
        LEFT JOIN project p ON c.ID = p.CLIENT_ID
        GROUP BY c.ID
    ) AS project_counts ;
