--
-- Constraints for table `groups_authority`
--
ALTER TABLE `groups_authority`
  ADD CONSTRAINT `FKF61BA29845B2B2BB` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  ADD CONSTRAINT `FKF61BA298C50078F9` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`id`);

--
-- Constraints for table `groups_user`
--
ALTER TABLE `groups_user`
  ADD CONSTRAINT `FK62B6CF56706BA843` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK62B6CF56C50078F9` FOREIGN KEY (`groups_id`) REFERENCES `groups` (`id`);

--
-- Constraints for table `user_authority`
--
ALTER TABLE `user_authority`
  ADD CONSTRAINT `FKB55BEBCF45B2B2BB` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  ADD CONSTRAINT `FKB55BEBCF706BA843` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
