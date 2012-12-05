CREATE TABLE `securitylogtransaction` (                    
                          `id` bigint(20) NOT NULL AUTO_INCREMENT,                 
                          `entity` varchar(200) NOT NULL,                          
                          `oldvalue` varchar(200) DEFAULT NULL,                    
                          `newvalue` varchar(200) NOT NULL,                        
                          `processdate` datetime DEFAULT NULL,                     
                          `username` varchar(60) NOT NULL,                         
                          `operation` varchar(60) NOT NULL,                        
                          PRIMARY KEY (`id`)                                       
                        )