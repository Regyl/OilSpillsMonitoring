
INSERT INTO location (longitude, latitude) VALUES (72.325, 60.46552);
INSERT INTO location (longitude, latitude) VALUES (72.925, 60.96552);
INSERT INTO location (longitude, latitude) VALUES (73.325, 61.46552);

INSERT INTO location (longitude, latitude) VALUES (76.648159720400002, 61.211680340900003);
INSERT INTO location (longitude, latitude) VALUES (76.048159720400002, 60.611680340900003);
INSERT INTO location (longitude, latitude) VALUES (75.648159720400002, 60.211680340900003);

INSERT INTO location (longitude, latitude) VALUES (72.6977, 60.7527);
INSERT INTO location (longitude, latitude) VALUES (73.0977, 61.2527);
INSERT INTO location (longitude, latitude) VALUES (73.6977, 61.7527);

INSERT INTO location (id, longitude, latitude) VALUES ('f7ef88f9-afc3-4b93-bda3-87edda3a5100', 66.38664114, 61.42105568);
INSERT INTO location (longitude, latitude) VALUES (65.88664114, 60.92105568);
INSERT INTO location (id, longitude, latitude) VALUES ('84c78c07-d147-4c1e-80e3-4db7494df212', 65.38664114, 60.42105568);

INSERT INTO location (id, longitude, latitude) VALUES ('06fdc52a-b1f9-4882-a321-3ab06c6bccf3', 72.214444444444453, 60.466388888888893);
INSERT INTO location (longitude, latitude) VALUES (72.914444444444453, 60.066388888888893);
INSERT INTO location (id, longitude, latitude) VALUES ('06047db0-72ea-42eb-ad0b-279c8aab736d', 73.214444444444453, 59.466388888888893);


INSERT INTO pollution (start_location, end_location, hazard_type, date)
VALUES ('06fdc52a-b1f9-4882-a321-3ab06c6bccf3', '06047db0-72ea-42eb-ad0b-279c8aab736d', 'LOW_DANGER', current_date);

INSERT INTO pollution (start_location, end_location, hazard_type, date)
VALUES ('f7ef88f9-afc3-4b93-bda3-87edda3a5100', '84c78c07-d147-4c1e-80e3-4db7494df212', 'LOW_DANGER', '2020-08-07');



